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

File site = new File( basedir, 'target/site/' )

File f = new File( site, 'custom-report.html' );
assert f.exists();
assert f.text.contains( 'Custom Maven Report content.' );

f = new File( site, 'custom-report-with-renderer.html' );
assert f.exists();
text = f.text.normalize();
assert text.contains( 'Custom Maven Report with Renderer content.' );
// TODO align with use-as-direct-mojo as soon as Maven Site Plugin uses Doxia 2.0.0-M5
assert text.contains( '''\
<div class="verbatim">
<pre>Custom verbatim text.</pre></div>'''.normalize() );
assert text.contains( '''\
<div class="verbatim source">
<pre>var custom_code = true;</pre></div>'''.normalize() );

f = new File( site, 'external/report.html' );
assert f.exists();
assert f.text.contains( '<h1>External Report</h1>' );

return true;
