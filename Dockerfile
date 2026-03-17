FROM node:latest AS build

WORKDIR /front

# package을 현재 루트로 복사
COPY package*.json ./

RUN npm install

# 현재 디렉토리에 있는 모든 것을 복사
COPY . .

RUN npm run build

# prod
FROM nginx:latest
COPY --from=build /front/build /usr/share/nginx/html

EXPOSE 88

CMD ["nginx", "-g", "daemon off;"]