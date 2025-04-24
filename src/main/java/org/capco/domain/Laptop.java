package org.capco.domain;

public final class Laptop implements Product{
    @Override
    public double getPriceBy(Client c) {
        return switch (c){
            case IndividualClient client -> 1200;
            case LegalClient(int id, String social, int tvaNumber, String siren, double profit) when profit >= 10_000_000 -> 900;
            case LegalClient(int id, String social, int tvaNumber, String siren, double profit) when profit < 10_000_000 -> 1000;
            default -> 0;
        };
    }
}
