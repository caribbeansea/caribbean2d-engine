package com.luots.caribbean2d

import com.luots.caribbean2d.input.{gui_input, key_handler, mouse_handler}
import com.luots.caribbean2d.renderer.gui_renderer
import com.luots.caribbean2d.state.{game_state, game_state_manager}
import com.luots.caribbean2d.update.gui_update
import com.luots.caribbean2d.utils.lists

import java.awt.Graphics2D
import java.util
import javax.swing.JPanel

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
 * @author tiansheng
 */
class game_panel extends JPanel with gui_renderer
  with gui_update with gui_input {

  val state_manager = new game_state_manager()

  override def render(graphics: Graphics2D, x: Int, y: Int, w: Int, h: Int): Unit = {

  }

  override def update(): Unit = {

  }

  override def input(key_h: key_handler, mouse_h: mouse_handler): Unit = {

  }

}
