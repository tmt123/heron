// Copyright 2016 Twitter. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.twitter.heron.spi.common;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClusterDefaultsTest {
  private Config props;

  @Before
  public void initialize() {
    props = Config.newBuilder(true).build();
  }

  @Test
  public void testSandboxBinaries() throws Exception {

    assertEquals(Key.SANDBOX_EXECUTOR_BINARY.getDefault(), Context.executorSandboxBinary(props));
    assertEquals(Key.SANDBOX_STMGR_BINARY.getDefault(), Context.stmgrSandboxBinary(props));
    assertEquals(Key.SANDBOX_TMASTER_BINARY.getDefault(), Context.tmasterSandboxBinary(props));
    assertEquals(Key.SANDBOX_SHELL_BINARY.getDefault(), Context.shellSandboxBinary(props));
    assertEquals(
        Key.SANDBOX_PYTHON_INSTANCE_BINARY.getDefault(),
        Context.pythonInstanceSandboxBinary(props)
    );
  }

  @Test
  public void testDefaultJars() throws Exception {
    assertEquals(Key.SCHEDULER_JAR.getDefault(), Context.schedulerJar(props));
  }

  @Test
  public void testDefaultMiscellaneous() throws Exception {
    assertEquals(Key.VERBOSE.getDefault(), Context.verbose(props));
    assertEquals(Key.SCHEDULER_IS_SERVICE.getDefault(), Context.schedulerService(props));
  }

  @Test
  public void testDefaultResources() throws Exception {
    Config defaultResources = props;

    assertEquals(Key.STMGR_RAM.getDefault(), Context.stmgrRam(defaultResources));
    assertEquals(
        (Double) Key.INSTANCE_CPU.getDefault(), Context.instanceCpu(defaultResources), 0.001);
    assertEquals(Key.INSTANCE_RAM.getDefault(), Context.instanceRam(defaultResources));
    assertEquals(Key.INSTANCE_DISK.getDefault(), Context.instanceDisk(defaultResources));
  }
}
