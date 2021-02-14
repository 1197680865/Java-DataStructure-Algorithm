package niuke;

/**
 * 剑指offer 第2题
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 思路：新建一个数组的长度为 n + 2*blanknum，倒序变量原数组，遇到空格则依次写入 0 2 %
 */
public class JZ2_ReplaceChar {
    public static void main(String[] args) {
       String string = "We Are Happy.";
        System.out.println(replaceSpace(new StringBuffer(string)));
    }

    public static String replaceSpace(StringBuffer str) {
        //方法一 调用自带函数
        /*
        String rawStr = str.toString();
        return rawStr.replace(" ","%20");
        */

        //方法2
        /*
        int size = str.length();
        StringBuffer sb = new StringBuffer(size);
        for(int i=0;i<size;i++){
            char c = str.charAt(i);
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
        */

        //方法3 重要. 不需要新的字符串对象
        //1.先找到有多少个空格，然后设置字符串长度,长度为 原长度 + 空格数*2
        //2.在原strbuffer上倒序遍历

        int blankNum = 0;
        int rawStrLength = str.length();
        for(int i=0;i<rawStrLength;i++){
            if(str.charAt(i) == ' '){
                blankNum ++;
            }
        }
        int newStrLength = rawStrLength + blankNum*2;
        str.setLength( newStrLength);

        int tmpNewStrIdx = newStrLength-1;
        for(int j= rawStrLength-1; j>=0; j--){
            char c = str.charAt(j);
            if(c==' '){
                str.setCharAt(tmpNewStrIdx--,'0');
                str.setCharAt(tmpNewStrIdx--,'2');
                str.setCharAt(tmpNewStrIdx--,'%');
            }else{
                str.setCharAt(tmpNewStrIdx--,c);
            }
        }
        return str.toString();

    }
}
