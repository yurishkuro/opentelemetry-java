/*
 * Copyright 2019, OpenConsensus Authors
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

package openconsensus.opencensusshim.internal;

import javax.annotation.concurrent.Immutable;
import openconsensus.opencensusshim.common.Clock;
import openconsensus.opencensusshim.common.Timestamp;

/** A {@link Clock} that always returns 0. */
@Immutable
public final class ZeroTimeClock extends Clock {
  private static final ZeroTimeClock INSTANCE = new ZeroTimeClock();
  private static final Timestamp ZERO_TIMESTAMP = Timestamp.create(0, 0);

  private ZeroTimeClock() {}

  /**
   * Returns a {@code ZeroTimeClock}.
   *
   * @return a {@code ZeroTimeClock}.
   */
  public static ZeroTimeClock getInstance() {
    return INSTANCE;
  }

  @Override
  public Timestamp now() {
    return ZERO_TIMESTAMP;
  }

  @Override
  public long nowNanos() {
    return 0;
  }
}
