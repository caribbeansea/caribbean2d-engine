package com.torvbell.game_engine.state

import com.torvbell.game_engine.input.{gui_input, key_handler, mouse_handler}
import com.torvbell.game_engine.renderer.gui_renderer
import com.torvbell.game_engine.update.gui_update
import com.torvbell.game_engine.utils.lists

import java.awt.Graphics2D
import java.util

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
 * 游戏状态管理器，管理每个状态在合适被渲染以及被销毁。
 *
 * @author tiansheng
 */
class game_state_manager extends gui_renderer with gui_update
  with gui_input {

  /** 游戏状态列表 */
  private val states: util.ArrayList[game_state] = lists.new_arraylist()

  /**
   * 添加游戏状态
   *
   * @param state 游戏状态对象实例
   */
  def add_state(state: game_state): Unit = states.add(state)

  /**
   * 删除游戏状态
   *
   * @param status 状态值
   */
  def delete_state(status: Int): Unit = states.remove(status)

  def delete_state(status: game_state): Unit = states.remove(status)

  override def render(graphics: Graphics2D, x: Int, y: Int, w: Int, h: Int): Unit = {
    states.forEach(e => e.render(graphics, x, y, w, h))
  }

  override def update(): Unit = {
    states.forEach(e => e.update())
  }

  override def input(key_h: key_handler, mouse_h: mouse_handler): Unit = {
    states.forEach(e => e.input(key_h, mouse_h))
  }

}
