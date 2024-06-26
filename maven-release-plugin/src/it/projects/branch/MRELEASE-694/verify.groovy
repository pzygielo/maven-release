
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import groovy.xml.XmlSlurper

File buildLog = new File( basedir, 'build.log' )
assert buildLog.exists()

assert buildLog.getText().contains("[INFO] Full run would be commit 1 files with message: '[maven-release-plugin] prepare branch RELEASE-2.6.0'")

def projectBranch = new XmlSlurper().parse( new File( basedir, "pom.xml.branch" ) )
assert projectBranch.version.text() == "2.6.0-BRANCH-SNAPSHOT"

def projectNext = new XmlSlurper().parse( new File( basedir, "pom.xml.next" ) )
assert projectNext.version.text() == "2.6.1-DEV-SNAPSHOT"

return true
