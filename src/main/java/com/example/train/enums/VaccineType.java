package com.example.train.enums;

public enum VaccineType {
    HEPATITISB(1), BCG(2), HIB(3), IPV(4), PCV(5), PENTAVALENT(6), ROTAVIRUS(7), INFLUENZA(8), MMR(9), VARICELLA(10), HEPATITISA(11), DTAP(12), HPV(13), MENINGOCOCCAL(14);

    private final int value;
    VaccineType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
