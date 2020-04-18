public class testt {
    public static void main(String[] args) {
        String str = "thisismyoriginalstring";
        String toDelete = "original";

        if (str.startsWith(toDelete)) {
            str = str.substring(toDelete.length());
        } else if (str.endsWith(toDelete)) {
            str = str.substring(0,str.length() - toDelete.length());
        } else {
            int index = str.indexOf(toDelete);
            //found the string to be deleted
            if (index != -1) {
                StringBuilder str1 = new StringBuilder(str.substring(0,index));
                StringBuilder str2 = new StringBuilder(str.substring(index+toDelete.length()));
                StringBuilder strr = new StringBuilder();
                strr.append(str1);
                strr.append(str2);
                System.out.println(strr);
            } else {
                System.out.println("string "+toDelete+"/"+"not found");
            }
        }
        System.out.println(str.indexOf(toDelete));
        System.out.println(str.substring(0,str.indexOf(toDelete)));
        
    }   
}