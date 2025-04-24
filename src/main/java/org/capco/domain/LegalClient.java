package org.capco.domain;

public record LegalClient(int id, String social, int tvaNumber, String siren, double profit) implements Client { }
