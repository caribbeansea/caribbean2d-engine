package com.luots.caribbean2d.animation

import com.luots.caribbean2d.input.{gui_input, key_handler, mouse_handler}
import com.luots.caribbean2d.renderer.gui_renderer
import com.luots.caribbean2d.update.gui_update
import com.luots.caribbean2d.utils.tool_box

import java.awt.Graphics2D
import java.awt.image.BufferedImage
import javax.swing.Renderer
import scala.::

/* ************************************************************************
 *
 * Copyright (C) 2020 dahan All rights reserved.
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
 *
 * ************************************************************************/

/*
 * Creates on 2021/1/17.
 */

/**
 * 游戏动画类, 所有的动画靠它去进行播放
 *
 * @param frames 当前动画的所有帧
 * @param speed  动画的播放速度
 * @author tiansheng
 */
class animation(var frames: Array[BufferedImage], var speed: Float = 0.1F)
  extends gui_renderer {

  /** 记录当前播放到第几帧 */
  var current_frame: Int = 0

  /** 最大帧数 */
  var total_frame: Int = frames.length

  /** 播放次数 */
  var time_played: Int = 0

  /** 上次的播放时间 */
  var last_time: Long = tool_box.get_time_seconds()

  def this(frames: Array[BufferedImage]) {
    this(frames, speed = 0.1F)
  }

  /** 设置当前播放帧数 */
  def set_current_frame(c_f: Int): Unit = {
    if (c_f > total_frame) {
      current_frame = 0
    } else {
      this.current_frame = c_f;
    }
  }

  def get_time_played(): Int = time_played

  override def render(graphics: Graphics2D, x: Int, y: Int, w: Int, h: Int): Unit = {

    if (speed < 0.01F)
      return

    if (current_frame == total_frame) {
      current_frame = 0
      time_played += 1
      return
    }

    val current_time: Long = tool_box.get_time_seconds()
    val interval: Long = last_time - current_time

    if (interval > speed)
      graphics.drawImage(frames(current_frame), x, y, w, h, null)

    last_time = current_time
    current_frame += 1
  }

}