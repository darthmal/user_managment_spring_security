package com.starter.domain.project.common.utils;

public class ValidationMessages {

    public final static String INVALID_DATES = "Valid to cannot be before valid from";
    public final static String SLIP_TYPE_IN_USE = "Slip type is still in use and cannot be deleted";
    public final static String SLIP_TYPE_DENOMINATIONS_IN_USE = "Slip type denomination is still in use and cannot be deleted";
    public final static String SLIP_PROVISION_RANGES_EMPTY = "Slip provision ranges cannot be empty";
    public final static String SLIP_TRANSFER_RANGES_EMPTY = "Slip transfer ranges cannot be empty";
    public final static String SLIP_RANGES_CANNOT_BE_EMPTY = "Slip ranges cannot be empty";
    public final static String IDENTICAL_SENDER_RECEIVER_UNIT = "Sender and receiver units cannot be the identical";

    private ValidationMessages(){}
}
