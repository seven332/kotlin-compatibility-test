/*
 * Copyright 2018 Hippo Seven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hippo.kotlin.compatibility.test

import kotlin.test.Test

/**
 * Add new methods to interfaces.
 */
class InterfaceAddMethodTest {

  /**
   * Call the unchanged method.
   * PASS
   */
  @Test
  fun callUnchangedMethod() {
    val implement: InterfaceAddMethod = InterfaceAddMethodImplement()
    implement.unchangedMethod()
  }

  /**
   * Call the new method.
   * FAIL
   */
  @Test
  fun callNewMethod() {
    val implement: InterfaceAddMethod = InterfaceAddMethodImplement()
    fail {
      implement.newMethod()
    }
  }
}

/**
 * Add new methods with body to interfaces.
 */
class InterfaceAddMethodWithBodyTest {

  /**
   * Call the unchanged method.
   * PASS
   */
  @Test
  fun callUnchangedMethod() {
    val implement: InterfaceAddMethodWithBody = InterfaceAddMethodWithBodyImplement()
    implement.unchangedMethod()
  }

  /**
   * Call the new method.
   * FAIL
   */
  @Test
  fun callNewMethod() {
    val implement: InterfaceAddMethodWithBody = InterfaceAddMethodWithBodyImplement()
    fail {
      implement.newMethod()
    }
  }
}
