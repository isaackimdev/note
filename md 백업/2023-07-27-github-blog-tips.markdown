---
title: Github Blog Tips
date: 2023-07-27 00:00:00 +0000
categories: [Github, Blog]
tags: [github, blog, jekyll]     # TAG names should always be lowercase
author: isaac
comments: true
---


# Github Blog Tips

## Github Page 블로그 개발/운영 팁
Github Blog 개발/운영을 하면서 알게 된 것들이나 도움이 될 만한 것들을 공유하기 위해 작성한 글입니다. 새로운 정보를 알게 되면 이 글에 내용을 추가하여 글을 update 할 것입니다.


### 목차
1. Github 블로그 글에 이미지 배치하기

---

### 1. Github 블로그 글에 이미지 배치하기

Naver, Tistory 같은 블로그에서는 글에 이미지를 추가할 때 파일 선택창에서 이미지를 선택하면 자동으로 블로그 글에 이미지가 포함됩니다. Github Blog에서는 이미지 파일을 특정 경로에 저장해 두고 해당 경로에서 이미지를 불러오도록 블로그 글에 코드로 작성해야 합니다.

#### 방법
일반적으로 웹에서 정적인 파일(이미지 같은 파일)을 보관할 때 __assets__ 이라는 이름의 폴더에 저장합니다. 블로그 프로젝트 루트 디렉토리(Root Directory or 최상위 디렉토리)에 assets 이라는 디렉토리를 생성하고 img 폴더를 생성합니다. (폴더명은 꼭 img가 아니어도 됩니다.) 생성한 img 폴더에 이미지 파일을 저장합니다.

다음은 제 프로필 이미지 파일 경로입니다.

##### 이미지 파일 경로
![image path](/assets/img/2023-07-27/1.png)

`/assets/img/isaac-illustrator.jpg`

저장되어 있는 이미지 파일(isaac-illustrator.jpg)을 이 글에 삽입하겠습니다. 현재 이 글은 Markdown 파일로 작성되었습니다. Markdown에 이미지 파일을 배치하는 코드는 다음과 같습니다.

##### Markdown 파일에 이미지 삽입
`![name](/path){:width="50%"}`

##### isaac-illustrator.jpg 이미지 삽입하기 코드
`![isaac-illustrator](/assets/img/isaac-illustrator.jpg){:width="30%"}`

##### Github 블로그 프로필 이미지 배치하기
![isaac-illustrator](/assets/img/isaac-illustrator.jpg){:width="30%"}