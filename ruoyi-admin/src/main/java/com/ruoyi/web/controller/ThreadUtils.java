/*
 * Copyright (C) 2022 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.ruoyi.web.controller;

public class ThreadUtils {


    public static Thread getThread(String name) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        /* 遍历线程组树，获取根线程组 */
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
        /* 激活的线程数加倍 */
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slackList = new Thread[estimatedSize];
        /* 获取根线程组的所有线程 */
        int actualSize = topGroup.enumerate(slackList);
        /* copy into a list that is the exact size */
        Thread[] list = new Thread[actualSize];
        System.arraycopy(slackList, 0, list, 0, actualSize);

        for (int i = 0; i < list.length; i++) {
            if (list[i].getName().equals(name)) {
                return list[i];
            }
        }
        return null;
    }

}
