package hu.ak_akademia.oop.piresian;

import hu.ak_akademia.oop.piresian.general.*;
import hu.ak_akademia.oop.piresian.operator.OperatorServicePointImpl;

import java.util.Objects;


/**
 * <b>Exercise: Piresian Mobile Tariffs #1 (Piréz mobiltelefon-tarifák #1)</b>
 * <p>
 * The main program.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
public class Main {
    public static void main(String[] args) throws InvalidInput {
        new Main().run();
    }

    @SuppressWarnings("unused")
    private final Operator[] operators = OperatorServicePointImpl.getInstance().getAvailableOperators();

    private void run() throws InvalidInput {
        var th = new TextHolder();
        th.welcome();
        th.printUserInfo();
        try (var userInput = new UserInput()) {
            for (; true; ) {
                try {
                    process(userInput);
                } catch (InvalidCharacterException |InvalidLengthOfPhoneNumber | AreaNumberStartWithZeroException |
                         InvalidLengthOfLocalComponent | WithoutPrefixException | NumberFormatException |
                         ArrayIndexOutOfBoundsException | NullPointerException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    @SuppressWarnings("unused")
    public void process(UserInput userInput) throws InvalidInput {
        PhoneNumber phoneNumber = userInput.askPhoneNumber("Add meg a hívószámot távhívás formátumban: ");
        Operator operator = identifyOperator(phoneNumber);
        phoneNumber.makePosteriorCheck(operator);
        Duration duration = userInput.askCallDuration("Add meg a hívás időtartamát (<perc>:<mp>): ");
        Operator cheapestOperator = identifyCheapestOperator(duration);
        printOperatorData(operator, duration);
        printCheapestOperatorData(cheapestOperator, duration);
    }

    private Operator identifyOperator(PhoneNumber phoneNumber) {
        Operator operator = null;
        for (Operator o : OperatorServicePointImpl.getInstance().getAvailableOperators()) {
            if (phoneNumber.getNormalForm().startsWith(o.getOperatorSpecifyNumber())) {
                operator = o;
                break;
            }
        }
        return operator;
    }

    private Operator identifyCheapestOperator(Duration duration) {
        double cheapestOperator = Double.MAX_VALUE;
        String operatorName = null;
        Operator operator = null;
        for (Operator o : OperatorServicePointImpl.getInstance().getAvailableOperators()) {
            if (o.getPrice(duration) < cheapestOperator) {
                cheapestOperator = o.getPrice(duration);
                operatorName = o.getOperatorName();
            }
        }
        for (Operator o : OperatorServicePointImpl.getInstance().getAvailableOperators()) {
            if (Objects.equals(operatorName, o.getOperatorName())) {
                operator = o;
            }
        }
        return operator;
    }

    void printOperatorData(Operator operator, Duration duration) {
        System.out.println("A hívás szolgáltatója: " + operator.getOperatorName() + ", " + "díja: "
                + operator.getPrice(duration) + " peták" + " (díjazása: " + operator.getPricing() + ")");

    }

    void printCheapestOperatorData(Operator operator, Duration duration) {
//        System.out.println("A megadott idejű hívásra a " + operator.getOperatorName() + " a legolcsóbb szolgáltató.");
        System.out.println("A megadott idejű hívásra a " + operator.getOperatorName() + " lenne a legolcsóbb szolgáltató" +
                ", a díjuk csak " + operator.getPrice(duration) + " peták.");
    }
}
