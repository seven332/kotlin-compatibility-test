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
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

/**
 * Add new parameters to data classes.
 */
class DataClassAddParameterTest {

  /**
   * Access the unchanged parameter.
   * JVM: PASS
   * JS:  FAIL
   */
  @Test
  fun accessUnchangedParameter(): Unit = when (PLATFORM) {
    Platform.JVM -> {
      fail {
        val data: DataClassAddParameter = DATA_CLASS_ADD_PARAMETER_IMPLEMENT
        assertEquals(1, data.unchangedParameter)
      }
    }
    Platform.JS -> {
      val data: DataClassAddParameter = DATA_CLASS_ADD_PARAMETER_IMPLEMENT
      assertEquals(1, data.unchangedParameter)
    }
  }

  /**
   * Access the new parameter.
   * JVM: FAIL
   * JS:  the new parameter is undefined
   */
  @Test
  fun accessNewParameter(): Unit = when (PLATFORM) {
    Platform.JVM -> {
      fail {
        val data: DataClassAddParameter = DATA_CLASS_ADD_PARAMETER_IMPLEMENT
        println(data.newParameter)
      }
    }
    Platform.JS -> {
      val data: DataClassAddParameter = DATA_CLASS_ADD_PARAMETER_IMPLEMENT
      println(data.newParameter)
      fail {
        assertNotNull(data.newParameter)
      }
    }
  }
}
