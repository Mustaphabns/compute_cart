package org.capco.domain;

sealed interface Product permits HighPhone, LowPhone, Laptop {
   double getPriceBy(Client c);
}
