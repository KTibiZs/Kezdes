package hu.ak_akademia.oop.piresian.operator;

import hu.ak_akademia.oop.piresian.Operator;
import hu.ak_akademia.oop.piresian.OperatorServicePoint;

/**
 * <b>Exercise: Piresian Mobile Tariffs #1 (Piréz mobiltelefon-tarifák #1)</b>
 * <p>
 * Service/contact point of the package.<br>
 * Coming from its role, this is the only public class in the package.<br>
 * Singleton design pattern is applied.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
public class OperatorServicePointImpl implements OperatorServicePoint {

    private static final OperatorServicePoint INSTANCE = new OperatorServicePointImpl();

    public static OperatorServicePoint getInstance() {
        return INSTANCE;
    }

    private final Operator[] operators = {new ChatterMobileLtd(), new QuillAerialsLtd(), new ReliantTelecomCo()};

    private OperatorServicePointImpl() {
    }

    @Override
    public Operator[] getAvailableOperators() {
        return operators;
    }
}
