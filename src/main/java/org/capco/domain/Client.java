package org.capco.domain;

public sealed interface Client permits IndividualClient, LegalClient {
}
