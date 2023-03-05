package com.models;

import java.util.List;

public class OutputFile {
    private List<ConsumerSummary>  customerSummaries;

    public OutputFile() {
    }



    public List<ConsumerSummary> getCustomerSummaries() {
        return customerSummaries;
    }

    public void setCustomerSummaries(List<ConsumerSummary> customerSummaries) {
        this.customerSummaries = customerSummaries;
    }
    @Override
    public String toString() {
        return "OutputFile{" +
                "customerSummaries=" + customerSummaries +
                '}';
    }
}
