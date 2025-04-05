public class _7_cli_var_args {
    public static void main(String[] args) {
        System.out.println("By having var args, we can give the arguments in cli itself and acheive th edesired operation. Just compile this file and use cli commands to find the sum of numbers");

        int total = 0;
        for(String x: args){
            total+=Double.parseDouble(x);
        }
        System.out.println("The total is: "+total);

    }
}
