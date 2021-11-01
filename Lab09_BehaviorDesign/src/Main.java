import java.util.Scanner;
import java.util.concurrent.Flow.Subscriber;

public class Main {
    public static void main(String[] args) {
        StringPublisher publisher = new StringPublisher();
        Scanner scanner = new Scanner(System.in);
        String s = "";

        Subscriber alphabet = new AlphabetSubscriber();
        Subscriber symbol = new SymbolSubscriber();
        Subscriber number = new NumberSubscriber();

        publisher.subscribe(alphabet);
        publisher.subscribe(symbol);
        publisher.subscribe(number);

        while (true) {
            System.out.print("Enter text: ");
            s = scanner.nextLine();
            publisher.publish(s);
        }
    }
}