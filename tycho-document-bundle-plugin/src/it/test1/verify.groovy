/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
 
 def checkFile = { fileName, message ->
    File file = new File(basedir, fileName);
    if (!file.isFile()) {
      throw new Exception( message + ": " + file );
    }
 }
 
 def checkFileContains = { fileName, content ->
    File file = new File(basedir, fileName);
    String fileContent = file.text
    if (!fileContent.contains(content)) {
      throw new Exception("Expected content '" + content + "' could not be found in file " + file);
    }
     
 }

 checkFileContains ( "docbundle1/target/javadoc.options.txt", "-docletpath" );
 checkFileContains ( "docbundle1/target/javadoc.options.txt", "-doclet CustomDoclet" ); 
 checkFile ( "docbundle1/target/gen-doc/toc/javadoc.xml", "Missing expected toc file" ); 
 checkFile ( "docbundle1/target/gen-doc/reference/api/package-list", "Missing package list file" );
 checkFile ( "docbundle1/target/gen-doc/reference/api/bundle1/SampleClass1.html", "Missing doc file" );
  
 return true;