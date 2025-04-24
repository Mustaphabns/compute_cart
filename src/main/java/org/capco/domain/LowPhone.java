package org.capco.domain;

public final class LowPhone implements Product {
    @Override
    public double getPriceBy(Client c) {
        return switch (c){
            case IndividualClient client -> 800;
            case LegalClient(int id, String social, int tvaNumber, String siren, double profit) when profit >= 10_000_000 -> 550;
            case LegalClient(int id, String social, int tvaNumber, String siren, double profit) when profit < 10_000_000 -> 600;
            default -> 0;
        };
    }
}
