package com.compomics.pepshell.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Davy Maddelein
 */
public class Experiment {

    private final int experimentId;
    private final String experimentName;
    private List<Protein> proteinList = new ArrayList<>();
    private double maxIntensity = Double.MIN_VALUE;
    private double minIntensity = Double.MAX_VALUE;
    private Double maxRatio = Double.MIN_VALUE;

    public Experiment(String experimentName) {
        this.experimentId = -1;
        this.experimentName = experimentName;
    }

    public Experiment(int experimentId, String experimentName) {
        this.experimentId = experimentId;
        this.experimentName = experimentName;
    }

    public int getExperimentId() {
        return experimentId;
    }

    public void setProteins(List<Protein> fetchedProteins) {
        proteinList.clear();
        proteinList.addAll(fetchedProteins);
    }

    public void addProteins(List<Protein> proteins) {
        proteinList.addAll(proteins);
    }

    public List<Protein> getProteins() {
        return Collections.unmodifiableList(proteinList);
    }

    public void addProtein(Protein aProtein) {
        if (!proteinList.contains(aProtein)) {
            proteinList.add(aProtein);
        } else {
            proteinList.get(proteinList.indexOf(aProtein)).addPeptideGroups(aProtein.getPeptideGroups());
        }
    }

    public String getExperimentName() {
        return experimentName;
    }

    @Override
    public String toString() {
        return experimentName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.experimentId;
        hash = 61 * hash + (this.experimentName != null ? this.experimentName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Experiment other = (Experiment) obj;
        return this.experimentId == other.getExperimentId() && !((this.experimentName == null) ? (other.getExperimentName() != null) : !this.experimentName.equals(other.getExperimentName()));
    }

    public double getMaxIntensity() {
        return maxIntensity;
    }

    public void setMaxIntensity(double maxIntensity) {
        this.maxIntensity = maxIntensity;
    }

    public double getMinIntensity() {
        return minIntensity;
    }

    public void setMinIntensity(double minIntensity) {
        this.minIntensity = minIntensity;
    }

    public Double getMaxRatio() {
        return maxRatio;
    }

    public void setMaxRatio(Double aRatio) {
        maxRatio = aRatio;
    }
}