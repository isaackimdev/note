# next.js

[NEXT.JS GUIDE](https://nextjs.org)

## next.js를 시작하는 방법

Next.js를 시작하기 위해서는 먼저 Node.js 18.17 이상 버전이 필요하다.

### Node.js 설치 여부 확인 :
```sh
node -v
```

### next.js project 생성 : 
```sh
npx create-next-app@latest
```

### 의존성 최신화 : 
```sh
npm install next@latest react@latest react-dom@latest
```

### project start

package.json에서 scripts 에서 프로젝트를 실행한다.
- `next dev`
- > npm run dev


### Routing
Next.js는 파일 시스템 routing을 하고 있다.

App Router - `app` directory  사용을 추천한다.

`app/` 폴터에 `layout.tsx`, `page.tsx` 파일이 root ( / ) 경로로 렌더링된다.

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

## Learn Next.js
### Overview
- Styling: The different ways to style your application in Next.js.
- Optimizations: How to optimize images, links, and fonts.
- Routing: How to create nested layouts and pages using file-system routing.
- Data Fetching: How to set up a database on Vercel, and best practices for fetching and streaming.
- Search and Pagination: How to implement search and pagination using URL Search Params.
- Mutating Data: How to mutate data using React Server Actions, and revalidate the Next.js cache.
- Error Handling: How to handle general and 404 not found errors.
- Form Validation and Accessibility: How to do server-side form validation and tips for improving accessibility.
- Authentication: How to add authentication to your application using NextAuth.js and Middleware.
- Metadata: How to add metadata and prepare your application for social sharing.