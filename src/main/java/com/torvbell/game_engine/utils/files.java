package com.torvbell.game_engine.utils;

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

import java.io.File;

/**
 * @author tiansheng
 */
public class files
{

    public static String getExtension(File file)
    {
        return getExtension(file.getName());
    }

    /**
     * 获取文件后缀名
     *
     * @param filename 文件名
     * @return 后缀
     */
    public static String getExtension(String filename)
    {
        return filename.substring((filename.indexOf(".") + 1));
    }

}
