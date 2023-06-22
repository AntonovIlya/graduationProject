package cim.datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Voltage {

    private float value;
    private final UnitSymbol unit = UnitSymbol.V;
    private UnitMultiplier multiplier = UnitMultiplier.k;

    public Voltage(float value) {
        this.value = value;
    }

    public Voltage(float value, UnitMultiplier multiplier) {
        this.value = value;
        this.multiplier = multiplier;
    }

    public Voltage() {
    }
}
