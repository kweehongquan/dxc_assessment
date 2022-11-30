import java.util.Scanner;

class Display {
    public void displayInterface(){
        encoderDecoder ed = new encoderDecoder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select either 1 for encoder, 2 for decoder, or 3 to exit.");
        
        if (sc.hasNextInt()){
            int option = sc.nextInt();
            sc.nextLine();
            
            if (option == 1){
                System.out.println("Please input text for encoding.");
                String input = sc.nextLine();
                System.out.println("The encoded text is: " + ed.encode(input));
                System.out.println("");
                displayInterface();
            } else if (option == 2){
                System.out.println("Please input encoded text for decoding.");
                String input = sc.nextLine();
                System.out.println("The decoded text is: " + ed.decode(input));
                System.out.println("");
                displayInterface();
            } else if (option == 3){
                System.exit(0);
            } 
        }
        sc.close(); 
    }
}
