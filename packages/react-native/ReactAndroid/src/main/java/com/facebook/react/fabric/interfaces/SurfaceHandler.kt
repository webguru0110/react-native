/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.react.fabric.interfaces

import com.facebook.react.bridge.NativeMap
import javax.annotation.concurrent.ThreadSafe

/** Represents a Java variant of the surface, its status and inner data required to display it. */
@ThreadSafe
interface SurfaceHandler {

  /**
   * Provides current surface id. Id should be updated after each call to {@link
   * SurfaceHandler#stop}
   */
  val surfaceId: Int

  val isRunning: Boolean

  val moduleName: String

  /** Starts the surface if the surface is not running */
  fun start()

  /** Stops the surface if it is currently running */
  fun stop()

  fun setProps(props: NativeMap)

  /**
   * Updates current surface id. Id should be updated after each call to {@link SurfaceHandler#stop}
   */
  fun setSurfaceId(surfaceId: Int)

  fun setLayoutConstraints(
      widthMeasureSpec: Int,
      heightMeasureSpec: Int,
      offsetX: Int,
      offsetY: Int,
      doLeftAndRightSwapInRTL: Boolean,
      isRTL: Boolean,
      pixelDensity: Float
  )

  fun setMountable(mountable: Boolean)
}
