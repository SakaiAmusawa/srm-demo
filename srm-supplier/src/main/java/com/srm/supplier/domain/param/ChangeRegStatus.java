package com.srm.supplier.domain.param;

public class ChangeRegStatus {

    private Long id;
    private Integer registrationStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(Integer registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    @Override
    public String toString() {
        return "ChangeRegStatus{" +
                "id=" + id +
                ", registrationStatus=" + registrationStatus +
                '}';
    }
}
