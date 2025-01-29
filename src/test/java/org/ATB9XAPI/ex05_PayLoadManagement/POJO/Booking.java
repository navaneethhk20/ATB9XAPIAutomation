package org.ATB9XAPI.ex05_PayLoadManagement.POJO;

public class Booking {
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private boolean depositpaid;
    private String additionalfields;
    private  BookingDates bookingDates;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditionalfields() {
        return additionalfields;
    }

    public void setAdditionalfields(String additionalfields) {
        this.additionalfields = additionalfields;
    }

    public BookingDates getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }
}
