package org.capco.domain;

public final class HighPhone implements Product{

    @Override
    public double getPriceBy(Client c) {
       return switch (c){
           case IndividualClient client -> 1500;
           case LegalClient(int id, String social, int tvaNumber, String siren, double profit) when profit >= 10_000_000 -> 1000;
           case LegalClient(int id, String social, int tvaNumber, String siren, double profit) when profit < 10_000_000 -> 1150;
           default -> 0;
       };
    }
}
