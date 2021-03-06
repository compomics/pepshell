/*
 * Copyright 2014 Davy Maddelein.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.compomics.pepshell.view.drawmodes.Peptides;

import com.compomics.pepshell.FaultBarrier;
import com.compomics.pepshell.ProgramVariables;
import com.compomics.pepshell.model.protein.proteinimplementations.PepshellProtein;
import com.compomics.pepshell.model.QuantedPeptide;
import com.compomics.pepshell.model.exceptions.CalculationException;
import com.compomics.pepshell.model.exceptions.UndrawableException;
import com.compomics.pepshell.view.drawmodes.DrawProteinPeptidesInterface;
import com.compomics.pepshell.view.drawmodes.GradientDrawModeInterface;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Davy Maddelein
 */
public class QuantedPeptideDrawMode<T extends PepshellProtein, U extends QuantedPeptide> implements DrawProteinPeptidesInterface<T, U>, GradientDrawModeInterface<T, U> {

    private RatioType topnumber = RatioType.LIGHT;
    private RatioType divisor = RatioType.HEAVY;
    private double maxRatio = 0.0;
    private double minRatio = 0.0;

    @Override
    public void drawPeptide(U peptide, Graphics g, Point startPoint, int length, int height) throws UndrawableException {
        try {
            Color peptideColor = calculatePeptideGradient(peptide);
        } catch (CalculationException ex) {
            UndrawableException updatedEx = new UndrawableException("could not calculate the ratio gradient");
            updatedEx.initCause(ex);
            throw updatedEx;
        }
        DrawProteinPeptidesInterface.super.drawPeptide(peptide, g, startPoint, length, height);
    }

    @Override
    public Color calculatePeptideGradient(U peptide) throws CalculationException {
        Color gradientColor = null;
        if (peptide.getRatio() == null || maxRatio == 0.0) {
            if (peptide.getHeavy().isEmpty() && peptide.getLight().isEmpty()) {
                throw new CalculationException("could not calculate ratio, missing light and/or heavy values");
            } else {
            }
        }
        //if needed add medium here

        try {
            double logRatio = Math.log(peptide.getRatio());
            double absRatio = Math.abs(logRatio);

            if (peptide.getRatio() < 1.0) {
                float blue = (float) (absRatio / Math.abs(Math.log(minRatio)));

                gradientColor = new Color(0.0f, 1.0f - blue, blue);
            } else {
                float red = (float) (absRatio / Math.abs(Math.log(maxRatio)));

                gradientColor = new Color(red, 1.0f - red, 0.0f);
            }
        } catch (IllegalArgumentException iae) {
            FaultBarrier.getInstance().handleException(iae);
        }
        return gradientColor;

    }

    public void setTopNumber(RatioType aType) {
        this.topnumber = aType;
    }

    public void setDivisor(RatioType aType) {
        this.divisor = aType;
    }


    @Override
    public void drawColorLegend(Point legendStartPoint, Graphics g) {
        int colourCounter = 0;
        while (colourCounter < 51) {
            g.setColor(new Color(colourCounter * 5, 255 - (colourCounter * 5), 115));
            g.fillRect(legendStartPoint.x + colourCounter, legendStartPoint.y, 5, ProgramVariables.VERTICALSIZE);
            colourCounter += 5;
        }

        g.setColor(Color.black);
        g.drawString("low", legendStartPoint.x, legendStartPoint.y + 25);
        g.drawString("high", legendStartPoint.x + colourCounter - 5, legendStartPoint.y + 25);

    }

    public void setMaxRatio(double maxRatio) {
        this.maxRatio = maxRatio;
    }

    public void setMinRatio(double minRatio) {
        this.minRatio = minRatio;
    }

    public enum RatioType {

        LIGHT("light", "L"),
        HEAVY("heavy", "H");

        String type;
        String shorthand;

        RatioType(String type, String shorthand) {
            this.type = type;
            this.shorthand = shorthand;
        }

        public String getType() {
            return type;
        }

        public String getShorthand() {
            return shorthand;
        }
    }
}
