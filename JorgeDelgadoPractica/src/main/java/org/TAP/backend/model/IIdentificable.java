package org.TAP.backend.model;

public interface IIdentificable extends Cloneable{
    long getId();
    IIdentificable clonar() throws CloneNotSupportedException;
    void setId(long id);


}
