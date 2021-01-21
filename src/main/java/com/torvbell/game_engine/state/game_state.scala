package com.torvbell.game_engine.state

import com.torvbell.game_engine.input.{gui_input, key_handler, mouse_handler}
import com.torvbell.game_engine.renderer.gui_renderer
import com.torvbell.game_engine.update.gui_update

import java.awt.Graphics2D

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
 * Creates on 2021/1/21.
 */

/**
 * 游戏状态实例，所有的动画以及逻辑操作在状态中完成
 *
 * @author tiansheng
 */
class game_state(_manager: game_state_manager) extends gui_renderer with gui_update
  with gui_input {

  var manager: game_state_manager = _manager

  var _enable: Boolean = true /* 当前状态是否禁用 */

  /**
   * 启用当前状态
   */
  def enable(): Unit = _enable = true

  /**
   * 禁用当前状态
   */
  def disable(): Unit = _enable = false

  /**
   * 删除当前状态
   */
  def delete(): Unit = _manager.delete_state(status = this)

  override def render(graphics: Graphics2D, x: Int, y: Int, w: Int, h: Int): Unit = {

    if (!_enable)
      return

  }

  override def update(): Unit = {

    if (!_enable)
      return

  }

  override def input(key_h: key_handler, mouse_h: mouse_handler): Unit = {

    if (!_enable)
      return

  }

}
