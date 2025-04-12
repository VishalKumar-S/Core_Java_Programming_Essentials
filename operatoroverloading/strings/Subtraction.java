package operatoroverloading.strings;

public class Subtraction {

    public static void main(String[] args) {
        
    }

    private String subtract_strings(String a, String b){
        String result = "";
        for(char i: a.toCharArray()){
            if (b.indexOf(i)==-1){
                result+=i;
            }
        }
        
        return result;
    }

    public String stringSubstraction(String a, String b){
        return subtract_strings(a, b);
    }
}
