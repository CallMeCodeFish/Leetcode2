package newquestion.day35;

/**
 * @author Heng Yu
 * @date 6/13/20 7:47 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 772: Remove comments
 */
public class RemoveComments {
    public static void main(String[] args) {
        RemoveComments solution = new RemoveComments();
        String[] source = {"/*/dadb/*/aec*////*//*ee*//*//b*////*badbda//*bbacdbbd*//ceb//*cdd//**//de*////*","ec//*//*eebd/*/*//*////*ea/*/bc*//cbdacbeadcac/*/cee*//bcdcdde*//adabeaccdd//*", "ddadbede//*//*/*/ac/*/ea//*bbeb/*/ea//*a//*//*cdbeb*//ab/*/abde/*//*/d//**////*","e/*/eabeea/*///*c*////*dc*//bcadcde/*/acbe//*d/*/*//ae//*dc//*cc//*//*eaebb*//"};
        List<String> result = solution.removeComments(source);
        System.out.println(result);
    }

    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();

        boolean isMultiple = false;
        StringBuilder sb = new StringBuilder();

        for (String line : source) {
            if (isMultiple) {
                int endIndex = line.indexOf("*/");
                if (endIndex != -1) {
                    isMultiple = false;
                    int remainStart = endIndex + 2;
                    int multipleIndex = -1;
                    while ((multipleIndex = line.indexOf("/*", remainStart)) != -1) {
                        sb.append(line.substring(remainStart, multipleIndex));
                        isMultiple = true;
                        endIndex = line.indexOf("*/", multipleIndex + 2);
                        if (endIndex == -1) {
                            break;
                        } else {
                            isMultiple = false;
                            remainStart = endIndex + 2;
                        }
                    }
                    if (!isMultiple) {
                        remainStart = endIndex + 2;
                        int singleIndex = line.indexOf("//", remainStart);
                        if (singleIndex == -1) {
                            sb.append(line.substring(remainStart));
                        } else {
                            sb.append(line.substring(remainStart, singleIndex));
                        }
                        if (sb.length() != 0) res.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }
            } else {
                int singleIndex = line.indexOf("//");
                int multipleIndex = line.indexOf("/*");
                if (singleIndex == -1 && multipleIndex == -1) {
                    if (!line.isEmpty()) {
                        res.add(line);
                    }
                } else if (singleIndex == -1) {
                    isMultiple = true;
                    sb.append(line.substring(0, multipleIndex));
                    int endIndex = -1;
                    while ((endIndex = line.indexOf("*/", multipleIndex + 2)) != -1) {
                        isMultiple = false;
                        int remainStart = endIndex + 2;
                        multipleIndex = line.indexOf("/*", remainStart);
                        if (multipleIndex == -1) {
                            sb.append(line.substring(remainStart));
                            if (sb.length() != 0) res.add(sb.toString());
                            sb = new StringBuilder();
                            break;
                        } else {
                            isMultiple = true;
                            sb.append(line.substring(remainStart, multipleIndex));
                        }
                    }
                } else if (multipleIndex == -1) {
                    if (singleIndex > 0) {
                        res.add(line.substring(0, singleIndex));
                    }
                } else {
                    if (singleIndex < multipleIndex) {
                        if (singleIndex > 0) {
                            res.add(line.substring(0, singleIndex));
                        }
                    } else {
                        isMultiple = true;
                        sb.append(line.substring(0, multipleIndex));
                        int endIndex = -1;
                        while ((endIndex = line.indexOf("*/", multipleIndex + 2)) != -1) {
                            isMultiple = false;
                            int remainStart = endIndex + 2;
                            multipleIndex = line.indexOf("/*", remainStart);
                            if (multipleIndex == -1) {
                                singleIndex = line.indexOf("//", remainStart);
                                if (singleIndex == -1) {
                                    sb.append(line.substring(remainStart));
                                } else {
                                    sb.append(line.substring(remainStart, singleIndex));
                                }
                                if (sb.length() != 0) res.add(sb.toString());
                                sb = new StringBuilder();
                                break;
                            } else {
                                singleIndex = line.indexOf("//", remainStart);
                                if (singleIndex >= remainStart && singleIndex < multipleIndex) {
                                    sb.append(line.substring(remainStart, singleIndex));
                                    if (sb.length() != 0) res.add(sb.toString());
                                    sb = new StringBuilder();
                                    break;
                                } else {
                                    isMultiple = true;
                                    sb.append(line.substring(remainStart, multipleIndex));
                                }
                            }
                        }
                    }
                }
            }
        }

        return res;
    }
}
