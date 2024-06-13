# next.js

- [node.js](https://nodejs.org/)
- [NEXT.JS GUIDE](https://nextjs.org)

## next.js를 시작하는 방법

Next.js를 시작하기 위해서는 먼저 Node.js 18.17 이상 버전이 필요하다.

### Node.js 설치 여부 확인 :
```sh
node -v
```

### next.js project 생성 : 
```sh
> npx create-next-app@latest
```

### 의존성 최신화 : 
```sh
npm install next@latest react@latest react-dom@latest
```

### project start

package.json에서 scripts 에서 프로젝트를 실행한다.
- next dev

```sh
npm run dev
```


### Routing
Next.js는 파일 시스템 routing을 하고 있다.

App Router,  `app` directory  사용을 추천한다.

`app/` 폴터에 `layout.tsx`, `page.tsx` 파일이 root(/) 경로로 렌더링된다.

초기 설정 페이지
```tsx
// layout.tsx
export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  );
}
```

```tsx
// page.tsx
export default function Page() {
    return <h1>Hello, Next.js!</h1>
}
```



### 유의사항
- Next는 기본적으로는 Server Component를 사용한다.
- useState는 Server Component에서 사용할 수 없다.
- Client Component로 사용할 경우, 파일 최상단에 `'use client';` 를 선언한다.



### Next.js 관련 참고할 웹 사이트
- [Static Exports](https://nextjs.org/docs/pages/building-your-application/deploying/static-exports)
- [Tailwind-typography](https://github.com/tailwindlabs/tailwindcss-typography)