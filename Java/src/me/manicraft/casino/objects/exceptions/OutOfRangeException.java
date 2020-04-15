package me.manicraft.casino.objects.exceptions;

public class OutOfRangeException extends Exception {

    private static final long serialVersionUID = 4206289419999478250L;

    public OutOfRangeException(String msg) {
        super(msg);
    }

    public OutOfRangeException() {
        super();
    }

}
