/*
 * Copyright 2015-2018 Norbert Potocki (norbert.potocki@nort.pl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cfg4j.source.reload.strategy;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.cfg4j.source.reload.Reloadable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ImmediateReloadStrategyTest {

  @Mock
  private Reloadable resource;

  @Test
  void reloadsResourceOnce() {
    ImmediateReloadStrategy reloadStrategy = new ImmediateReloadStrategy();
    reloadStrategy.register(resource);

    verify(resource, times(1)).reload();
  }

  @Test
  void doesntReloadWhenDeregistrated() {
    ImmediateReloadStrategy reloadStrategy = new ImmediateReloadStrategy();
    reloadStrategy.register(resource);
    reloadStrategy.deregister(resource);

    verify(resource, times(1)).reload();
  }
}