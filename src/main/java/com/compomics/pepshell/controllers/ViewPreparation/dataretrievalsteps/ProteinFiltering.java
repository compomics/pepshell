package com.compomics.pepshell.controllers.ViewPreparation.dataretrievalsteps;

import com.compomics.pepshell.controllers.InfoFinders.DataRetrievalStep;
import com.compomics.pepshell.controllers.filters.FilterParent;
import com.compomics.pepshell.controllers.filters.NaiveFilter;
import com.compomics.pepshell.model.Protein;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davy
 */
public class ProteinFiltering extends DataRetrievalStep {

    private FilterParent<Protein> filter = new NaiveFilter<>();
    private List<Protein> filterList = new ArrayList<>();

    private ProteinFiltering(List<Protein> aProteinList) {
        this.proteinList = aProteinList;
    }

    public ProteinFiltering() {
    }

    public void setFilter(FilterParent<Protein> filter) {
        this.filter = filter;
    }

    public void setFilterList(List<Protein> filterList) {
        this.filterList = filterList;
    }

    public DataRetrievalStep getInstance(List<Protein> aProteinList) {
        ProteinFiltering toReturn = new ProteinFiltering(aProteinList);
        toReturn.setFilter(filter);
        toReturn.setFilterList(filterList);
        return toReturn;
    }

    @Override
    public List<Protein> call() throws Exception {

        List<Protein> returnList = proteinList;
        if (!filterList.isEmpty()) {
            this.setChanged();
            this.notifyObservers("filtering protein list");
            returnList = filter.filter(proteinList, filterList);
            this.notifyObservers("done filtering");

        }
        return returnList;

    }

    @Override
    public String toString() {
        return "Protein Filtering";
    }
}