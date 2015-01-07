package com.compomics.pepshell.model;

/**
 *
 * @author Davy Maddelein
 */
public class QuantedPeptideGroup extends PeptideGroup {

    private Integer ratio;
    private int timesHeavyFound = 0;
    private int timesLightFound = 0;
    private ProjectInfo projectInfo;

    public QuantedPeptideGroup(Peptide aPeptide) {
        super(aPeptide);
    }

    public int getRatio() {
        if (ratio == null) {

        }
        return ratio;
    }

    public double getLogRatio() {
        return Math.log(getRatio());
    }

    public int getTimesHeavyFound() {
        return timesHeavyFound;
    }

    public void setTimesHeavyFound(int timesHeavyFound) {
        this.timesHeavyFound = timesHeavyFound;
    }

    public int getTimesLightFound() {
        return timesLightFound;
    }

    public void setTimesLightFound(int timesLightFound) {
        this.timesLightFound = timesLightFound;
    }

    public void incrementTimesHeavyFound() {
        timesHeavyFound++;
    }

    public void incrementTimesLightFound() {
        timesLightFound++;
    }

    public ProjectInfo getProjectInfo() {
        return this.projectInfo;
    }

}