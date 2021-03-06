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

package com.compomics.pepshell.controllers;

import com.compomics.pepshell.controllers.DAO.DAUtils.WebUtils;
import com.compomics.pepshell.model.exceptions.ConversionException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA. User: Davy Date: 3/4/13 Time: 11:16 AM To change
 * this template use File | Settings | File Templates.
 */
public class AccessionConverter {

    public static List<String> spToUniProt(String aSpAccession) throws IOException {
        String xmlPage = WebUtils.getPage("http://www.ebi.ac.uk/Tools/picr/rest/getUPIForAccession?accession=" + aSpAccession + "&database=SWISSPROT");
        List<String> accessions = new ArrayList<>();
        int startIndex = 0;
        while (xmlPage.indexOf("<ns2:databaseDescription>UniProtKB/Swiss-Prot</ns2:databaseDescription>", startIndex) != -1) {
            startIndex = xmlPage.indexOf("<ns2:databaseDescription>UniProtKB/Swiss-Prot</ns2:databaseDescription>", startIndex) + 1;
            String feature = xmlPage.substring(xmlPage.indexOf("<ns2:identicalCrossReferences>", startIndex - 200), xmlPage.indexOf("</ns2:identicalCrossReferences>", xmlPage.indexOf("<ns2:identicalCrossReferences>", startIndex - 200)));
            String sub = feature.substring(feature.indexOf("<ns2:accession>") + 15, feature.indexOf("</ns2:accession>"));
            accessions.add(sub);

        }
        return accessions;
    }

    public static List<String> refSeqToSp(String aNcbiAccession) throws IOException {
        int startIndex = 0;
        List<String> accessions = new ArrayList<>();
        String xmlPage = WebUtils.getPage("http://www.ebi.ac.uk/Tools/picr/rest/getUPIForAccession?accession=" + aNcbiAccession + "&database=swissprot");
        while (xmlPage.indexOf("<ns2:databaseDescription>SWISSPROT</ns2:databaseDescription>", startIndex) != -1) {
            startIndex = xmlPage.indexOf("<ns2:databaseDescription>SWISSPROT</ns2:databaseDescription>", startIndex) + 1;
            String feature = xmlPage.substring(xmlPage.indexOf("<ns2:logicalCrossReferences>", startIndex - 200), xmlPage.indexOf("</ns2:logicalCrossReferences>", xmlPage.indexOf("<ns2:logicalCrossReferences>", startIndex - 200)));
            String sub = feature.substring(feature.indexOf("<ns2:accession>") + 15, feature.indexOf("</ns2:accession>"));
            accessions.add(sub);

        }
        return accessions;
    }

    public static List<String> spToRefSeq(String aSpAccession) throws IOException {
        int startIndex = 0;
        List<String> ncbiAccessions = new ArrayList<>();
        String xmlPage = WebUtils.getPage("http://www.ebi.ac.uk/Tools/picr/rest/getUPIForAccession?accession=" + aSpAccession + "&database=REFSEQ");
        while (xmlPage.indexOf("<ns2:databaseDescription>RefSeq release + updates</ns2:databaseDescription>", startIndex) != -1) {
            startIndex = xmlPage.indexOf("<ns2:databaseDescription>RefSeq release + updates</ns2:databaseDescription>", startIndex) + 1;
            String feature = xmlPage.substring(xmlPage.indexOf("<ns2:identicalCrossReferences>", startIndex - 200), xmlPage.indexOf("</ns2:identicalCrossReferences>", xmlPage.indexOf("<ns2:identicalCrossReferences>", startIndex - 200)));
            String sub = feature.substring(feature.indexOf("<ns2:accession>") + 15, feature.indexOf("</ns2:accession>"));
            ncbiAccessions.add(sub);

        }
        return ncbiAccessions;
    }

    public static List<String> uniProtToSp(String aUniprotAccession) {
        int startIndex = 0;
        List<String> accessions = new ArrayList<>();

        return accessions;
    }

    public static List<String> uniProtToRefSeq(String aUniprotAccession) {
        int startIndex = 0;
        List<String> accessions = new ArrayList<>();

        return accessions;
    }

    public static String GIToUniprot(String GINumber) throws IOException, ConversionException {
        String splitaccession = GINumber.substring(GINumber.indexOf("|") + 1);
        String conversion = WebUtils.getPage("http://www.uniprot.org/mapping/?from=P_GI&to=ACC&format=tab&query=" + splitaccession);
        conversion = conversion.substring(conversion.lastIndexOf("\t") + 1, conversion.lastIndexOf("\n"));
        if (!conversion.matches("To")) {
            return conversion;
        } else {
            throw new ConversionException("Could not convert GI number");
        }
    }
    //TODO finish this, needs to take any accession and try to convert to uniprot

    /**
     * tries to convert a given accession to uniprot accession, if the conversion is not supported, it will return the accession given to the method unaltered
     * @param accession the protein accession to convert to uniprot accession
     * @return the converted accession if possible, otherwise the original accession
     * @throws IOException 
     * @throws ConversionException 
     */
    public static String toUniprot(String accession) throws IOException, ConversionException {
        String tempaccession = accession;
        if (isGIAccession(accession)) {
            tempaccession = GIToUniprot(accession);
        } //else if (isSwissprotAccession(accession)) {
            //TODO check if it is possible to get the isoform data from swissprot to uniprot
            // tempaccession = spToUniProt(accession).get(0);
            //}
        //}
        return tempaccession;
    }

    private static boolean isGIAccession(String accession) {
        return accession.toLowerCase(Locale.UK).contains("gi");
        //return accession.matches("^(GI|gi)\\|[0-9].*");
    }

    private static boolean isSwissprotAccession(String accession) {
        return accession.matches("something something something");
    }
}
