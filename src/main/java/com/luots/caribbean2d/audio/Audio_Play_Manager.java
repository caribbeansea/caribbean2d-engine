package com.luots.caribbean2d.audio;

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
 * Creates on 2020/12/30.
 */

import com.luots.caribbean2d.utils.Lists;

import java.util.List;

/**
 * 音乐播放管理。每播放一个音乐或者一个音效就将他们提交到这个类来
 * 进行管理。每个音效的播放都会单独开一个线程去播放。
 *
 * @author tiansheng
 */
public class Audio_Play_Manager
{

    /**
     * 当前正在播放的音效
     */
    private static final List<Thread> playing = Lists.newArrayList();

    /**
     * 提交一个播放任务
     *
     * @param playTask 音频对象
     */
    public static void putAudioTask(Abstract_Audio_Play playTask)
    {
        playing.add(createThread(playTask));
    }

    private static Thread createThread(Abstract_Audio_Play playTask)
    {
        return new Thread(playTask);
    }

}
