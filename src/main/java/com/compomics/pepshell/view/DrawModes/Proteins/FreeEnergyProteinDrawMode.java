package com.compomics.pepshell.view.DrawModes.Proteins;

import com.compomics.pepshell.ProgramVariables;
import com.compomics.pepshell.model.Peptide;
import com.compomics.pepshell.model.Protein;
import com.compomics.pepshell.model.exceptions.CalculationException;
import com.compomics.pepshell.model.exceptions.UndrawableException;
import com.compomics.pepshell.view.DrawModes.PdbGradientDrawModeInterface;
import com.compomics.pepshell.view.DrawModes.StandardPeptideProteinDrawMode;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;

/**
 *
 * @author Davy
 * @param <T>
 * @param <U>
 */
public class FreeEnergyProteinDrawMode<T extends Protein, U extends Peptide> extends StandardPeptideProteinDrawMode<T, U> implements PdbGradientDrawModeInterface<T, U> {
    
    private String pdbAccession;
    
    @Override
    public void drawProtein(T protein, Graphics g, int horizontalOffset, int verticalOffset, int horizontalBarSize, int verticalBarWidth) throws UndrawableException {

        int sizePerAminoAcid = (int) Math.ceil(horizontalBarSize / protein.getProteinSequence().length());
        
        if (ProgramVariables.STRUCTUREDATASOURCE.isAbleToGetFreeEnergy() && pdbAccession != null) {
            Map<Integer, Double> freeEnergyValues = ProgramVariables.STRUCTUREDATASOURCE.getFreeEnergyForStructure(protein, pdbAccession);
            //go over all locations retrieved from the data source
            for (int location : freeEnergyValues.keySet()) {
                Double relSasValue = freeEnergyValues.get(location);
                //check for null values
                if (relSasValue != null) {
                    Color freeEnergyGradientColor = new Color(Math.min((int) Math.ceil(relSasValue * 255), 255), 255, 125);
                    g.setColor(freeEnergyGradientColor);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(horizontalOffset + (location * sizePerAminoAcid), verticalOffset, sizePerAminoAcid, verticalBarWidth);
            }
        } else {
            g.setColor(Color.black);
            g.drawString("could not draw the free energy", horizontalOffset, verticalOffset + 5);
            throw new UndrawableException("could not calculate gradient");
        }
    }

    public Color calculateAminoAcidGradient(T protein, int location) throws CalculationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Color calculatePeptideGradient(U peptide) throws CalculationException {
        return ProgramVariables.PEPTIDECOLOR;
    }

    public void drawColorLegend(int xOffset, int yOffset, Graphics g) {
        double colorIncrement = 1 / 64;
        for (int i = 0; i > 64; i++) {
            g.setColor(new Color((int) Math.ceil((255 * colorIncrement)), 125, 125));
            colorIncrement += 1 / 64;
            g.fillRect(xOffset + i * 5, yOffset, 5, ProgramVariables.VERTICALSIZE);
        }
    }

    public void setPdbAccession(String pdbAccession) {
        this.pdbAccession = pdbAccession;
    }

}
