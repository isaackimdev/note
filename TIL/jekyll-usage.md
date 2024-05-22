## isaackimdev.github.io

Github Page Blog

Make sure Ruby and Jekyll are installed.
```console
$ ruby -v
$ gem -v
$ jekyll -v
```

Jekyll install command
```console
$ gem install jekyll bundler
```



테마 사용을 위해 Jekyll theme bundle을 설치합니다.

Install bundle for jekyll-theme-chirpy

```console
$ bundle install
```

### Jekyll Blog Local 실행

```console
$ bundle exec jekyll serve
```

### 수정 사항을 바로 반영할 수 있는 옵션 --livereload
```console
$ bundle exec jekyll serve --livereload
```

Local 실행 URL http://127.0.0.1:4000/

운영중인 지킬 웹 서버 중지 시키기 단축키 : Ctrl + C

Jekyll Theme Web Site : 
[Chirpy Site](https://chirpy.cotes.page/)

내가 쓴 글 :
[티스토리-지킬-사이트 만들기](https://lifere.tistory.com/entry/Github-Pages-Jekyll-%EC%82%AC%EC%9A%A9%ED%95%B4%EC%84%9C-Github-%EB%B8%94%EB%A1%9C%EA%B7%B8-%EB%A7%8C%EB%93%A4%EA%B8%B0)



# Chirpy Starter

[![Gem Version](https://img.shields.io/gem/v/jekyll-theme-chirpy)][gem]&nbsp;
[![GitHub license](https://img.shields.io/github/license/cotes2020/chirpy-starter.svg?color=blue)][mit]

When installing the [**Chirpy**][chirpy] theme through [RubyGems.org][gem], Jekyll can only read files in the folders
`_data`, `_layouts`, `_includes`, `_sass` and `assets`, as well as a small part of options of the `_config.yml` file
from the theme's gem. If you have ever installed this theme gem, you can use the command
`bundle info --path jekyll-theme-chirpy` to locate these files.

The Jekyll team claims that this is to leave the ball in the user’s court, but this also results in users not being
able to enjoy the out-of-the-box experience when using feature-rich themes.

To fully use all the features of **Chirpy**, you need to copy the other critical files from the theme's gem to your
Jekyll site. The following is a list of targets:

```shell
.
├── _config.yml
├── _plugins
├── _tabs
└── index.html
```

To save you time, and also in case you lose some files while copying, we extract those files/configurations of the
latest version of the **Chirpy** theme and the [CD][CD] workflow to here, so that you can start writing in minutes.

## Prerequisites

Follow the instructions in the [Jekyll Docs](https://jekyllrb.com/docs/installation/) to complete the installation of
the basic environment. [Git](https://git-scm.com/) also needs to be installed.

## Installation

Sign in to GitHub and [**use this template**][use-template] to generate a brand new repository and name it
`USERNAME.github.io`, where `USERNAME` represents your GitHub username.

Then clone it to your local machine and run:

```console
$ bundle
```

## Usage

Please see the [theme's docs](https://github.com/cotes2020/jekyll-theme-chirpy#documentation).

## License

This work is published under [MIT][mit] License.

[gem]: https://rubygems.org/gems/jekyll-theme-chirpy
[chirpy]: https://github.com/cotes2020/jekyll-theme-chirpy/
[use-template]: https://github.com/cotes2020/chirpy-starter/generate
[CD]: https://en.wikipedia.org/wiki/Continuous_deployment
[mit]: https://github.com/cotes2020/chirpy-starter/blob/master/LICENSE
