/*
  from react to next.js

The <html> and <body> tags.
The <div> element with the id of app.
The react and react-dom scripts since you've installed them with NPM.
The Babel script because Next.js has a compiler that transforms JSX into valid JavaScript browsers can understand.
The <script type="text/jsx"> tag.
The document.getElementById() and ReactDom.createRoot() methods.
The React. part of the React.useState(0) function

다음 file type을 html 에서 js or jsx로 변경한다.

다음 app 폴더를 만들고 page.js 라는 파일명으로 복사 붙여넣기 한다.

package.json 파일에
 
  "scripts": {
    "dev": "next dev"
  },

위 구문을 추가하고  npm run dev 로 실행
*/

import { useState } from 'react';

function Header({ title }) {
  return <h1>{title ? title : 'Default title'}</h1>;
}
 
function HomePage() {
  const names = ['Ada Lovelace', 'Grace Hopper', 'Margaret Hamilton'];
 
  const [likes, setLikes] = useState(0);
 
  function handleClick() {
    setLikes(likes + 1);
  }
 
  return (
    <div>
      <Header title="Develop. Preview. Ship." />
      <ul>
        {names.map((name) => (
          <li key={name}>{name}</li>
        ))}
      </ul>
 
      <button onClick={handleClick}>Like ({likes})</button>
    </div>
  );
}