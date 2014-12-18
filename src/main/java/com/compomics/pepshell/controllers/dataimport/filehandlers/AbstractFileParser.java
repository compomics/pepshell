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

package com.compomics.pepshell.controllers.dataimport.filehandlers;

import com.compomics.pepshell.model.AnnotatedFile;
import com.compomics.pepshell.model.Experiment;
import com.compomics.pepshell.model.exceptions.CouldNotParseException;
import com.compomics.pepshell.model.exceptions.ExperimentMetaData;

import java.io.File;

/**
 * Created by svend on 02/12/2014.
 */
public class AbstractFileParser implements FileParserInterface<ExperimentMetaData> {
    @Override
    public Experiment parseExperimentFile(File aFile) throws CouldNotParseException {
        return null;
    }

    @Override
    public Experiment parseExperimentFile(AnnotatedFile<ExperimentMetaData> annotatedFile) throws CouldNotParseException {
        return null;
    }
}
