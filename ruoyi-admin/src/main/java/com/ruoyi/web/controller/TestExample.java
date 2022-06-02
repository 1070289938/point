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

public class TestExample {


    public static void main(String[] args) throws InterruptedException {

        Thread a= ThreadUtils.getThread("ChildThread");
        System.out.println(a);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                    System.out.println(i);
                }
            }

        });
        t.setName("ChildThread");
        t.start();
        t.interrupt();
        Thread.sleep(1000);
        a= ThreadUtils.getThread("ChildThread");
        System.out.println(a);
    }



}
